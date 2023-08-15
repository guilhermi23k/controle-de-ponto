package br.com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.adapter.LocalTimeAdapter;
import br.com.controller.ControllerEmpresa;
import br.com.model.Empresa;
import br.com.model.Horario;
import br.com.model.Ponto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/registro")
public class marcaPonto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       
    	
//		lê o JSON e retorna um objeto empresa
    	
		try {
			String rawJson = readRawJson(req, resp);
			List<String> jsons = separaJson(rawJson);
			Empresa emp = JsonToEmpresa(jsons.get(0));
			List<LocalDate> datas = jsonToDates(jsons.get(1));
			ControllerEmpresa controller = new ControllerEmpresa(emp);
			
			List<Horario>[] hrs = controller.subtraiMarcacoes();
			
			List<Horario> atrasos = hrs[0];
			List<Horario> hExtras = hrs[1];
			String json = geraJson(new Ponto(atrasos, hExtras));
			
			resp.setContentType("application/json");
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().write(json);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
        

        
        
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
    	rd.forward(req, resp);
    }
    
    protected String geraJson(Ponto jornadas) {
    	Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
                .create();;
              
        return gson.toJson(jornadas);

    	
    }
    
    protected String readRawJson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	resp.setContentType("application/json");
        // Lê o JSON da solicitação
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
    
    protected List<String> separaJson(String json) throws JSONException {
    	List<String> jsons = new ArrayList<>();
    	JSONObject obj = new JSONObject(json);
    	String jsonData = obj.getString("jsonData").toString();
    	jsons.add(jsonData);
    	String date = obj.getString("dateS").toString();
    	jsons.add(date);
    	return jsons;
    }
    
    protected Empresa JsonToEmpresa(String json) throws IOException, JSONException {
    	JSONObject obj = new JSONObject(json);
    	String jsonData = obj.toString();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
                .create();
        return gson.fromJson(jsonData, Empresa.class);
    }
    
    protected List<LocalDate> jsonToDates(String dates) throws JSONException {
    	List<LocalDate> datas = new ArrayList<>();
    	JSONObject obj = new JSONObject(dates);
    	JSONArray dtHorario = obj.getJSONArray("horario");
    	JSONArray dtMarcacao = obj.getJSONArray("marcacao");
    	return datas;
    	
    }
    
}

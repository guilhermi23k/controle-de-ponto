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
			String jsonReq = readRawJson(req, resp);
			Empresa emp = jsonToEmpresa(jsonReq);
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
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("{Erro nos dados do JSON}");
		} catch (JSONException e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("{Erro nos dados do JSON}");
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
    
    protected Empresa jsonToEmpresa(String json) throws JSONException {
    	List<Horario> horarios = new ArrayList<>();
    	List<Horario> marcacoes = new ArrayList<>();
    	
    	JSONObject obj = new JSONObject(json);
    	JSONArray horariosJson = obj.getJSONArray("horarios");
    	JSONArray marcacoesJson = obj.getJSONArray("marcacoes");
    	
    	for(int i=0; i<horariosJson.length(); i++) {
    		JSONObject hor = horariosJson.getJSONObject(i);
    		LocalTime entrada = LocalTime.parse(hor.getString("entrada"));
    		LocalTime saida = LocalTime.parse(hor.getString("saida"));
    		horarios.add(new Horario(entrada, saida));
    	}
    	
    	for(int i=0; i<marcacoesJson.length(); i++) {
    		JSONObject hor = marcacoesJson.getJSONObject(i);
    		LocalTime entrada = LocalTime.parse(hor.getString("entrada"));
    		LocalTime saida = LocalTime.parse(hor.getString("saida"));
    		marcacoes.add(new Horario(entrada, saida));
    	}
    	
    	return new Empresa(horarios, marcacoes);
    	
    }
    
    
}

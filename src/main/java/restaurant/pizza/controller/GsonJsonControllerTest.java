package restaurant.pizza.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;



public class GsonJsonControllerTest {
    @Test
    public void testDoGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new GsonJsonController().doGet(request, response);

        writer.flush();
        // Validate the result here. For example, check if the JSON string is as expected.
    }
}

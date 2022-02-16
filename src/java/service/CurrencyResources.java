package service;

import domain.Currency;
import domain.Device;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Date;
//import java.time.LocalDate;

@Path("/nbp")
public class CurrencyResources {

    public static final String URL = "http://api.nbp.pl/api/exchangerates/rates/C/USD/";
    public static final String json = "/?format=json";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Currency getCurrency(Date date) {
        Response response = ClientBuilder.newClient()
                .target(URL + date + json )
                .request(MediaType.APPLICATION_JSON).get();

        if (response.getStatus() == 200)
            return response.readEntity(Currency.class);
        return null;
    }
}

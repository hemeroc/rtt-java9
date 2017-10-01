package rtt.java9.code.sample.simple.http;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Http {

    public static void main(String[] args) throws URISyntaxException, InterruptedException, ExecutionException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://www.google.com/"))
            .GET()
            .build();

        CompletableFuture<HttpResponse<String>> response =
            httpClient.sendAsync(request, HttpResponse.BodyHandler.asString());

        Thread.sleep(2_000);
        if (response.isDone()) {
            System.out.println(response.get().statusCode());
            System.out.println(response.get().body());
        } else {
            response.cancel(true);
            System.out.println("Request took too long.");
        }
    }
}

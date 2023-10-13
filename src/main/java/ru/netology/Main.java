package ru.netology;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(64);

        server.addHandler("GET", "/messages", (request, responseStream) -> {
            try {
                server.responseWithoutContent(responseStream, "404", "Not Found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        server.addHandler("POST", "/messages", (request, responseStream) ->
                server.responseWithoutContent(responseStream, "503", "Service Unavailable"));


        server.start(9999);
    }
}



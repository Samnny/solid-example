package com.solid.ocp.problem;

public class Video {

    private String type;

    public void calculaInteresse () {

        if (type.equals("Movie")) {
            // calcula interesse baseado em filme
        } else if (type.equals("TVShow")) {
            // calcula interesse baseado em serie
        }
    }
}

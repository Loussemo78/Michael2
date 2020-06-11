package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavorisNeighbours() {

        List<Neighbour> favorisNeighbours = new ArrayList<>();
        for (Neighbour liste : neighbours) {
            if (liste.isFavoris()) {
                favorisNeighbours.add(liste);
            }
        }

        return favorisNeighbours;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */


    @Override
    public void changeFavorites(Neighbour neighbour) {
       neighbours.get(neighbours.indexOf(neighbour)).setFavoris(!neighbour.isFavoris());
    }
}

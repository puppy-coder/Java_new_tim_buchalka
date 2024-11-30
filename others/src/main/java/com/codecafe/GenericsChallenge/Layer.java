package com.codecafe.GenericsChallenge;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable>// This sets an upper bound, meaning anything that is
    //mappable can use this layer class. It also means we can use methods of mappable without casting
{
    private List<T> layerElements;
    public Layer(T[] layerElements){
        this.layerElements = new ArrayList<T>(List.of(layerElements));
        //This constructor lets the calling code pass an array to create a new layer.
    }

    public void addElements(T... elements){
        layerElements.addAll(List.of(elements));
    }

    public void renderLayer(){
        for(T element : layerElements){
            element.render();
        }
    }
}

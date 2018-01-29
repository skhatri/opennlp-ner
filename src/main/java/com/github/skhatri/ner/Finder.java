package com.github.skhatri.ner;

import com.github.skhatri.ner.models.NERType;
import com.github.skhatri.ner.models.TypeFactory;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Finder {
    private final TokenNameFinderModel model;
    private final NameFinderME finderME;

    public Finder(ModelProcessor modelProcessor) {
        this.model = modelProcessor.model();
        this.finderME = new NameFinderME(model);
    }

    public List<NERType> find(String text) {
        String[] tokens = text.split(" ");
        Span[] spans = finderME.find(tokens);

        return Arrays.stream(spans).map(s -> {
            StringBuilder locationBuilder = new StringBuilder();
            for (int i = s.getStart(); i < s.getEnd(); i++) {
                locationBuilder.append(tokens[i]).append(" ");
            }
            String type = s.getType();
            return TypeFactory.create(type, locationBuilder.toString().trim());
        }).collect(Collectors.toList());
    }
}

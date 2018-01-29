package com.github.skhatri.ner;

import com.github.skhatri.utils.ThisOrThat;
import opennlp.tools.namefind.TokenNameFinderModel;

import java.io.FileInputStream;
import java.io.InputStream;

public class ModelProcessor {
    private final InputStream inputStream;

    public ModelProcessor(ThisOrThat<String, InputStream> fileOrStream) {
        this.inputStream = fileOrStream.isRight() ? fileOrStream.right() : asStream(fileOrStream.left());
    }

    private InputStream asStream(String fileName) {
        try {
            return new FileInputStream(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public TokenNameFinderModel model() {
        TokenNameFinderModel model;
        try {
            model = new TokenNameFinderModel(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return model;
    }


}

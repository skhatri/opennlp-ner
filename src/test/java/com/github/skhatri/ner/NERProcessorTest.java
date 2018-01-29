package com.github.skhatri.ner;

import com.github.skhatri.ner.models.NERType;
import com.github.skhatri.utils.ThisOrThat;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class NERProcessorTest {


    @Tag("location")
    @DisplayName("test NER extraction")
    @Test
    public void testNER() throws Exception {
        ModelProcessor processor = new ModelProcessor(
                ThisOrThat.<String, InputStream>right(new FileInputStream("en-ner-location.bin")));

        Finder finder = new Finder(processor);

        List<NERType> places = finder.find("I live in Sydney");

        Assertions.assertEquals("Sydney", places.get(0).value());
    }
}

#!/bin/bash

download() {
  model=$1
  if [ -f "$model" ];
  then
    echo $model is up-to-date
  else
    echo downloading $model
    curl -o $model "http://opennlp.sourceforge.net/models-1.5/$model"
  fi

}

download en-ner-location.bin
download en-token.bin
download en-pos-maxent.bin
download en-pos-perceptron.bin
download en-ner-person.bin
download en-ner-date.bin
download en-ner-time.bin



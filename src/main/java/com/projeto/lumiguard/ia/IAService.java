package com.projeto.lumiguard.ia;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.springframework.stereotype.Service;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;

@Service
public class IAService {

    private final Classifier modelo;
    private final Instances estrutura;

    public IAService() throws Exception {
        // Carrega o modelo
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/weka/modelo.model"));
        this.modelo = (Classifier) ois.readObject();
        ois.close();

        // Cria a estrutura de atributos com os mesmos atributos do .arff
        ArrayList<Attribute> atributos = new ArrayList<>();

        // Atributo "bairro" com os mesmos valores do seu .arff
        ArrayList<String> bairros = new ArrayList<>();
        bairros.add("Boa Viagem");
        bairros.add("Casa Amarela");
        bairros.add("Santo Amaro");
        bairros.add("Afogados");
        bairros.add("Imbiribeira");
        bairros.add("Madalena");
        bairros.add("Cordeiro");
        bairros.add("Torre"); // adicione aqui todos os que estiverem no ARFF

        Attribute attrBairro = new Attribute("bairro", bairros);
        atributos.add(attrBairro);

        // Atributo "prioridade" (classe a ser prevista)
        ArrayList<String> prioridades = new ArrayList<>();
        prioridades.add("BAIXA");
        prioridades.add("MEDIA");
        prioridades.add("ALTA");
        Attribute attrPrioridade = new Attribute("prioridade", prioridades);
        atributos.add(attrPrioridade);

        // Cria estrutura de dados
        this.estrutura = new Instances("Denuncia", atributos, 0);
        this.estrutura.setClassIndex(1); // índice da prioridade
    }

    public String preverPrioridade(String bairro) throws Exception {
        Instance nova = new DenseInstance(2);
        nova.setValue(estrutura.attribute(0), bairro);
        nova.setDataset(estrutura);

        double resultado = modelo.classifyInstance(nova);
        return estrutura.classAttribute().value((int) resultado);
    }
}

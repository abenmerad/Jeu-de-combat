package com.service;


import com.google.gson.stream.JsonReader;
import com.items.armes.Arme;
import com.items.armes.ArmeADistance;
import com.items.armes.ArmeRapproche;
import com.items.consommables.Consommable;
import com.items.consommables.Degats;
import com.items.consommables.Vie;
import com.items.equipements.*;
import com.items.inventaire.Inventaire;
import com.items.objets.Objet;
import com.population.Animal;
import com.population.Elementaire;
import com.population.EtreVivant;
import com.population.Humain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AssetLoader {
    private final String pathEquipement;
    private final String pathArme;
    private final String pathInventaire;
    private final String pathPopulation;
    private final String pathConsommable;

    public AssetLoader() {
        this.pathEquipement = "src/com/assets/equipements.json";
        this.pathArme = "src/com/assets/armes.json";
        this.pathInventaire = "src/com/assets/inventaires.json";
        this.pathConsommable = "src/com/assets/consommables.json";
        this.pathPopulation = "src/com/assets/population.json";
    }

    public List<Consommable> ChargerConsommable() {
        List<Consommable> lesConsommables = new ArrayList<>();

        try (JsonReader reader = new JsonReader(new FileReader(pathConsommable))) {
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();

                String nom = "";
                float poids = 0;
                int point = 0;

                if (name.equals("Vie")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("poids")) {
                            poids = Float.parseFloat(item.get("poids").toString());
                        } else if (item.containsKey("point")) {
                            point = Integer.parseInt(item.get("point").toString());
                            lesConsommables.add(new Vie(nom, poids, point));
                        }
                    }
                } else if (name.equals("Degats")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("poids")) {
                            poids = Float.parseFloat(item.get("poids").toString());
                        } else if (item.containsKey("point")) {
                            point = Integer.parseInt(item.get("point").toString());
                            lesConsommables.add(new Degats(nom, poids, point));
                        }
                    }
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lesConsommables;
    }
    public List<EtreVivant> ChargerPopulation() {
        List<EtreVivant> lesEtresVivants = new ArrayList<>();

        try (JsonReader reader = new JsonReader(new FileReader(pathPopulation))) {
            reader.beginObject();
            while (reader.hasNext()) {

                String name = reader.nextName();

                String nom = "";
                int niveau = 0, sante = 0, armure = 0, degats = 0;

                if (name.equals("Humain")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("niveau")) {
                            niveau = Integer.parseInt(item.get("niveau").toString());
                        } else if (item.containsKey("sante")) {
                            sante = Integer.parseInt(item.get("sante").toString());
                        } else if (item.containsKey("armure")) {
                            armure = Integer.parseInt(item.get("armure").toString());
                        } else if (item.containsKey("degats")) {
                            degats = Integer.parseInt(item.get("degats").toString());
                            lesEtresVivants.add(new Humain(nom, niveau, sante, armure, degats));
                        }
                    }
                } else if (name.equals("Animal")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("niveau")) {
                            niveau = Integer.parseInt(item.get("niveau").toString());
                        } else if (item.containsKey("sante")) {
                            sante = Integer.parseInt(item.get("sante").toString());
                        } else if (item.containsKey("armure")) {
                            armure = Integer.parseInt(item.get("armure").toString());
                        } else if (item.containsKey("degats")) {
                            degats = Integer.parseInt(item.get("degats").toString());
                            lesEtresVivants.add(new Animal(nom, niveau, sante, armure, degats));
                        }
                    }
                } else if (name.equals("Elementaire")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("niveau")) {
                            niveau = Integer.parseInt(item.get("niveau").toString());
                        } else if (item.containsKey("sante")) {
                            sante = Integer.parseInt(item.get("sante").toString());
                        } else if (item.containsKey("armure")) {
                            armure = Integer.parseInt(item.get("armure").toString());
                        } else if (item.containsKey("degats")) {
                            degats = Integer.parseInt(item.get("degats").toString());
                            lesEtresVivants.add(new Elementaire(nom, niveau, sante, armure, degats));
                        }
                    }
                } else {
                reader.skipValue();
                }
            }

            reader.endObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lesEtresVivants;
    }

    public List<Armure> ChargerEquipement() {
        List<Armure> lesArmures = new ArrayList<>();

        try (JsonReader reader = new JsonReader(new FileReader(pathEquipement))) {
            reader.beginObject();
            while (reader.hasNext()) {

                String name = reader.nextName();
                String nom = "";
                float poids = 0;
                int point = 0;

                if (name.equals("Tete")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("poids")) {
                            poids = Float.parseFloat(item.get("poids").toString());
                        } else if (item.containsKey("point")) {
                            point = Integer.parseInt(item.get("point").toString());
                            lesArmures.add(new Tete(nom, poids, point));
                        }
                    }
                } else if (name.equals("Buste")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("poids")) {
                            poids = Float.parseFloat(item.get("poids").toString());
                        } else if (item.containsKey("point")) {
                            point = Integer.parseInt(item.get("point").toString());
                            lesArmures.add(new Buste(nom, poids, point));
                        }
                    }
                } else if (name.equals("Jambe")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("poids")) {
                            poids = Float.parseFloat(item.get("poids").toString());
                        } else if (item.containsKey("point")) {
                            point = Integer.parseInt(item.get("point").toString());
                            lesArmures.add(new Jambe(nom, poids, point));
                        }
                    }
                } else if (name.equals("Pied")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("poids")) {
                            poids = Float.parseFloat(item.get("poids").toString());
                        } else if (item.containsKey("point")) {
                            point = Integer.parseInt(item.get("point").toString());
                            lesArmures.add(new Pied(nom, poids, point));
                        }
                    }
                } else {
                    reader.skipValue(); //avoid some unhandle events
                }
            }

            reader.endObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lesArmures;
    }

    public List<Arme> ChargerArme() {
        List<Arme> lesArmes = new ArrayList<>();
        try (JsonReader reader = new JsonReader(new FileReader(pathArme))) {

            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();

                String nom = "";
                float poids = 0, precision = 0;
                int degats = 0;

                if (name.equals("Arme blanche")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("degats")) {
                            degats = Integer.parseInt(item.get("degats").toString());
                        } else if (item.containsKey("poids")) {
                            poids = Float.parseFloat(item.get("poids").toString());
                            lesArmes.add(new ArmeRapproche(nom, poids, degats));
                        }
                    }
                } else if (name.equals("Arme à lancer")) {
                    for (Map item : GetJsonData(reader)) {
                        if (item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("degats")) {
                            degats = Integer.parseInt(item.get("degats").toString());
                        } else if (item.containsKey("poids")) {
                            poids = Float.parseFloat(item.get("poids").toString());
                        } else if (item.containsKey("precision")) {
                            precision = Float.parseFloat(item.get("precision").toString());
                            lesArmes.add(new ArmeADistance(nom, poids, degats, precision));
                        }
                    }
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lesArmes;
    }

    public List<Inventaire> ChargerInventaire() {
        List<Inventaire> lesInventaires = new ArrayList<>();

        try (JsonReader reader = new JsonReader(new FileReader(pathInventaire))) {

            reader.beginObject();
            while (reader.hasNext()) {

                String name = reader.nextName();

                String nom = "";
                int capacite = 0;

                if (name.equals("Inventaire")) {
                    for (Map item : GetJsonData(reader)) {
                        if(item.containsKey("nom")) {
                            nom = item.get("nom").toString();
                        } else if (item.containsKey("capacite")) {
                            capacite = Integer.parseInt(item.get("capacite").toString());
                            lesInventaires.add(new Inventaire(nom, capacite));
                        }
                    }
                } else {
                    reader.skipValue(); //avoid some unhandle events
                }
            }

            reader.endObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lesInventaires;
    }

    private List<Map> GetJsonData(JsonReader reader) throws IOException {
        List<Map> lesObjets = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            reader.beginObject();
            while (reader.hasNext()) {
                Map<String, String> map = new HashMap<>();
                map.put(reader.nextName().toString(), reader.nextString().toString());
                lesObjets.add(map);
            }
            reader.endObject();
        }
        reader.endArray();
        return lesObjets;
    }
}



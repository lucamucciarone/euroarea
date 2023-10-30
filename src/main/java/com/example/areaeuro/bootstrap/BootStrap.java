package com.example.areaeuro.bootstrap;

import com.example.areaeuro.domain.*;
import com.example.areaeuro.repositories.OrganizzazioneRepository;
import com.example.areaeuro.repositories.RilevamentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Scanner;

@Component
public class BootStrap implements CommandLineRunner {
    private final OrganizzazioneRepository organizzazioneRepository;
    private final RilevamentoRepository rilevamentoRepository;

    public BootStrap(OrganizzazioneRepository organizzazioneRepository, RilevamentoRepository rilevamentoRepository) {
        this.organizzazioneRepository = organizzazioneRepository;
        this.rilevamentoRepository = rilevamentoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap - Start");
        //prestiti_nazione.txt
        Organizzazione italia = new Organizzazione();
        italia.setNomeNazione("Italia");
        italia= organizzazioneRepository.save(italia);
        Organizzazione germania = new Organizzazione();
        germania.setNomeNazione("Germania");
        germania= organizzazioneRepository.save(germania);
        Organizzazione spagna = new Organizzazione();
        spagna.setNomeNazione("Spagna");
        spagna= organizzazioneRepository.save(spagna);
        Organizzazione francia = new Organizzazione();
        francia.setNomeNazione("Francia");
        francia= organizzazioneRepository.save(francia);
        Organizzazione olanda = new Organizzazione();
        olanda.setNomeNazione("Olanda");
        olanda= organizzazioneRepository.save(olanda);
        Organizzazione europa = new Organizzazione();
        europa.setNomeNazione("Europa");
        europa= organizzazioneRepository.save(europa);

        Rilevamento r1 = new Rilevamento();
        r1.setImporto(5.75f);
        r1.setDataRilevamento(LocalDateTime.now());
        r1.setNazione(italia);
        r1=rilevamentoRepository.save(r1);

        /*
        italia.getRilevamenti().add(r1);
        italia = nazioneRepository.save(italia);*/

        System.out.println(System.getProperty("user.dir"));
        String filePath = "./prestiti_organizzazione.txt";
        File CSVFile = new File(filePath);
        Scanner sc = new Scanner(CSVFile);

        while (sc.hasNext())
        {
            sc.useDelimiter(";");
            //System.out.print(sc.next() + " | ");
            String dataCorrenteStringa = sc.next();
            dataCorrenteStringa=dataCorrenteStringa.replace("\r\n","");
            Integer[]dataCorrenteArray = getDataArray(dataCorrenteStringa);
            LocalDateTime dataRilevamentoCorrente = LocalDateTime.of(dataCorrenteArray[2], dataCorrenteArray[1], dataCorrenteArray[0], 0, 0);

            /*Germany;Spain;France;Italy;Netherlands;Euro area*/
            String importoGermania = sc.next();
            Rilevamento newRilevamentoGermania = new Rilevamento();
            newRilevamentoGermania.setNazione(germania);
            newRilevamentoGermania.setImporto(Float.parseFloat(importoGermania));
            newRilevamentoGermania.setDataRilevamento(dataRilevamentoCorrente);
            rilevamentoRepository.save(newRilevamentoGermania);

            String importoSpagna = sc.next();
            Rilevamento newRilevamentoSpagna = new Rilevamento();
            newRilevamentoSpagna.setNazione(spagna);
            newRilevamentoSpagna.setImporto(Float.parseFloat(importoSpagna));
            newRilevamentoSpagna.setDataRilevamento(dataRilevamentoCorrente);
            rilevamentoRepository.save(newRilevamentoSpagna);

            String importoFrancia = sc.next();
            Rilevamento newRilevamentoFrancia = new Rilevamento();
            newRilevamentoFrancia.setNazione(francia);
            newRilevamentoFrancia.setImporto(Float.parseFloat(importoFrancia));
            newRilevamentoFrancia.setDataRilevamento(dataRilevamentoCorrente);
            rilevamentoRepository.save(newRilevamentoFrancia);

            String importoItalia = sc.next();
            Rilevamento newRilevamentoItalia = new Rilevamento();
            newRilevamentoItalia.setNazione(italia);
            newRilevamentoItalia.setImporto(Float.parseFloat(importoItalia));
            newRilevamentoItalia.setDataRilevamento(dataRilevamentoCorrente);
            rilevamentoRepository.save(newRilevamentoItalia);

            String importoOlanda = sc.next();
            Rilevamento newRilevamentoOlanda = new Rilevamento();
            newRilevamentoOlanda.setNazione(olanda);
            newRilevamentoOlanda.setImporto(Float.parseFloat(importoOlanda));
            newRilevamentoOlanda.setDataRilevamento(dataRilevamentoCorrente);
            rilevamentoRepository.save(newRilevamentoOlanda);

            sc.useDelimiter("\r\n");
            String importoEuropa = sc.next();
            Rilevamento newRilevamentoEuropa = new Rilevamento();
            newRilevamentoEuropa.setNazione(europa);
           //importoEuropa = importoEuropa.replace(";" , "" ) ;
            importoEuropa = importoEuropa.split(";")[1];
            newRilevamentoEuropa.setImporto(Float.parseFloat(importoEuropa.split(";")[0]));
            newRilevamentoEuropa.setDataRilevamento(dataRilevamentoCorrente);
            rilevamentoRepository.save(newRilevamentoEuropa);
        }
        sc.close();
        System.out.println("Numero Nazioni : " + organizzazioneRepository.count());
        System.out.println("Numero Rilevamenti : " + rilevamentoRepository.count());
        System.out.println("Bootstrap - End");
    }

    private Integer[] getDataArray(String dataCorrenteStringa) {
        Integer[] arrayInt = new Integer[3];
        dataCorrenteStringa = dataCorrenteStringa.toLowerCase();
        String[] arrayStringhe = dataCorrenteStringa.split("-");
        arrayInt[0] = Integer.parseInt(arrayStringhe[0]);

        switch(arrayStringhe[1]) {
            case "gen":
                arrayInt[1]=1;
                break;
            case "feb":
                arrayInt[1]=2;
                break;
            case "mar":
                arrayInt[1]=3;
                break;
            case "apr":
                arrayInt[1]=4;
                break;
            case "mag":
                arrayInt[1]=5;
                break;
            case "giu":
                arrayInt[1]=6;
                break;
            case "lug":
                arrayInt[1]=7;
                break;
            case "ago":
                arrayInt[1]=8;
                break;
            case "set":
                arrayInt[1]=9;
                break;
            case "ott":
                arrayInt[1]=10;
                break;
            case "nov":
                arrayInt[1]=11;
                break;
            case "dic":
                arrayInt[1]=12;
                break;
            default:
                // code block
        }
        arrayInt[2] = Integer.parseInt(arrayStringhe[2]);
        arrayInt[2]=arrayInt[2]<100?arrayInt[2]+2000:arrayInt[2];
        return arrayInt;
    }
}

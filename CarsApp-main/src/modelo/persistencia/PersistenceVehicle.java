package modelo.persistencia;

import modelo.modelos.Estados;
import modelo.modelos.Segmento;
import modelo.modelos.Modelo;
import modelo.modelos.Version;
import modelo.modelos.Marca;
import modelo.modelos.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.Segment;
import modelo.modelos.Flete;
import modelo.modelos.Patentamiento;

public class PersistenceVehicle {

    
    private List<Color> colores = new ArrayList<>();
    private List<Marca> marcas = new ArrayList<>();
    private List<Modelo> modelos = new ArrayList<>();
    private List<Segmento> segmentos = new ArrayList<>();
    private List<Version> versiones = new ArrayList<>();
    
    //Marcas
    private Marca chevrolet = new Marca("Chevrolet");
    private Marca fiat = new Marca("Fiat");
    private Marca honda = new Marca("Honda");
    private Marca audi = new Marca("Audi");
    private Marca vw = new Marca("Volkswagen");
    private Marca bmw = new Marca("BMW");
    private Marca jeep = new Marca("Jeep");
    private Marca renault = new Marca("Renault");
    private Marca peugeot = new Marca("Peugeot");
    private Marca ford = new Marca("Ford");

    //Modelos

        //fiat
    private Modelo cronos = new Modelo("Cronos");
    private Modelo argo = new Modelo("Argo");
    private Modelo mobi = new Modelo("Mobi");
    private Modelo palio = new Modelo("Palio");
    private Modelo punto = new Modelo("Punto");
    private Modelo strada = new Modelo("Strada");

        //chevrolet
    private Modelo cruze = new Modelo("Cruze");
    private Modelo s10 = new Modelo("S10");

        //honda
    private Modelo fit = new Modelo("Fit");
    private Modelo crv = new Modelo("CRV");
    private Modelo city = new Modelo("City");
    private Modelo civic = new Modelo("Civic");


        //audi
    private Modelo a1 = new Modelo("A1");
    private Modelo a4 = new Modelo("A4");
    private Modelo tt = new Modelo("TT");
    private Modelo allroad = new Modelo("AllRoad");


        //volkswagen
    private Modelo amarok = new Modelo("Amarok"); //camioneta
    private Modelo voyage = new Modelo("Voyage");
    private Modelo t_cross = new Modelo("T-Cross");
    private Modelo vento = new Modelo("Vento");
    private Modelo virtus = new Modelo("Virtus");

        //BMW
    private Modelo x4 = new Modelo("X4");
    private Modelo x1 = new Modelo("X1");
    private Modelo s4 = new Modelo("Serie 4");
    private Modelo s3 = new Modelo("Serie 3");

    //Versiones

        //fiat
    private Version atrac = new Version("1.3 Attractive MT (99cv)");
    private Version drive = new Version("1.3 Drive MT (99cv)");
    private Version prec = new Version("Precision CVT (99cv)");
    private Version cent = new Version("Centenario SL (130cv)");
    private Version easy = new Version("1.0 Easy (75cv)");
    private Version like = new Version("1.0 Like (75cv)");
    private Version way = new Version("1.0 Way Live On (75cv)");
    private Version esse = new Version("Essence 1.6 5Ptas. (115cv)");
    private Version fire = new Version("Fire 1.3 3Ptas.");
    private Version adven = new Version("Adventure 1.8 Extreme");
    private Version trek = new Version("Trekking 1.3 JDT");
    private Version work = new Version("Working 1.4 Serie");
    private Version dualo = new Version("Dualogic 5Ptas. (115cv)");

        //chevrolet
    private Version x44 = new Version("2.8 4x4 (200cv)");
    private Version x42 = new Version("2.8 4x2 (180cv)");
    private Version x44H = new Version("2.8 4x4 HIGH Country (210cv)");
    private Version lt4p = new Version("LT MT (141cv) 4Ptas.");
    private Version lt5p = new Version("LT MT (141cv) 5Ptas.");
    private Version ltz = new Version("LTZ (141cv) 4Ptas.");

        //honda
    private Version exl = new Version("EXL MT ABS Cuero (120cv)");
    private Version lx = new Version("LX MT 2ABS (120cv)");
    private Version exs = new Version("EXS Sedán (140cv)");
    private Version lxs = new Version("LXS AT Sedán (154cv)");
    private Version lxl = new Version("LXL AT IVTEC (120cv)");
    private Version ex = new Version("EX MT IVTEC");
    private Version ex4x4 = new Version("EX 4X4 (185cv)");
    private Version ex4x2 = new Version("EX 4X2 (170cv)");
    private Version lx4x4 = new Version("LX 4X4 (185cv)");


        //audi
    private Version ambit = new Version("Ambition (122cv)");
    private Version attrac = new Version("MT Atraction (86cv)");
    private Version sportba = new Version("Sportback 1.4 TFSI (185cv)");
    private Version multitro = new Version("Multitronic Sport (140cv)");
    private Version tdi1 = new Version("TDI MT Plus (143cv)");
    private Version quatt = new Version("TFSI Quattro (225cv)");
    private Version coupe2 = new Version("Coupé 2.0 MT (211cv)");
    private Version coupe1 = new Version("Coupé 1.8T Sport (160cv)");
    private Version coupe3 = new Version("Coupé 3.2 V6 MT (250cv)");
    private Version rs = new Version("RS 2.5T FSI (340cv)");
    private Version fsi = new Version("FSI (255cv)");//camioneta
    private Version tdi2 = new Version("2.7 TDI (233cv)");//camioneta
    private Version biturb = new Version("2.7 Biturbo Tiptronic");//camioneta

        //volkswagen
    private Version trend4x4 = new Version("2.0 4X4 Trendline (140cv)");//camioneta
    private Version high4x4 = new Version("2.0 4X4 Highline (163cv)");//camioneta
    private Version high4x2 = new Version("2.0 4X2 Highline (163cv)");//camioneta
    private Version com4x4 = new Version("2.0 4X4 Comfortline (180cv)");//camioneta
    private Version com4x2 = new Version("2.0 4X2 Comfortline (170cv)");//camioneta
    private Version comf16 = new Version("1.6 Comfortline (101cv)");
    private Version high16 = new Version("1.6 Highline (101cv)");
    private Version trend16 = new Version("1.6 Trendline (101cv)");
    private Version adv16 = new Version("1.6 Advance (101cv)");
    private Version adv14 = new Version("1.4 TSI Advance (101cv)");
    private Version high14 = new Version("1.4 AT Highline (150cv)");
    private Version comf14 = new Version("1.4 TSI Comfortline (150cv)");
    private Version comf14manual = new Version("1.4 MSI Comfortline Manual");
    private Version style16 = new Version("1.6 Style Edition");


        //BMW
    private Version i20 = new Version("20i xDrive Active (184cv)");
    private Version i28 = new Version("28i xDrive xLine (245cv)");
    private Version i35 = new Version("35i xDrive M Package (306cv)");
    private Version i40 = new Version("xDrive M40i (354cv)");
    private Version i18 = new Version("18i sDrive Advantage (140cv)");
    private Version d204x4 = new Version("20d xDrive Active AT 4X4 (177cv)");//camioneta
    private Version d204x2 = new Version("20d xDrive Active MT 4X2 (177cv)");//camioneta
    private Version i25 = new Version("25i xDrive xLine (204cv)");//camioneta
    private Version i430 = new Version("430i Coupé M Sport Package (258cv)");
    private Version i428 = new Version("428i Coupé Sport Line (245cv)");
    private Version m4comp = new Version("M4 Competition Coupé (510cv) (L23)");
    private Version m4 = new Version("M4 Coupé (431cv)");
    private Version d320 = new Version("320d Sedán Executive (184cv) (L09)");
    private Version i320 = new Version("320i Sedán Active (156cv)");
    private Version i325 = new Version("325i Cabrio Pack M (L09)");


    //Colores
    private Color blanco = new Color("Blanco");
    private Color negro = new Color("Negro");
    private Color azul = new Color("Azul");
    //Segmentos
    private Segmento segmentoA = new Segmento("Segmento A");
    private Segmento segmentoB = new Segmento("Segmento B");
    private Segmento segmentoC = new Segmento("Segmento C");
    //Flete
    private Flete fleteB = new Flete();
    //Patentamiento
    private Patentamiento patentamientoB = new Patentamiento();

    
    public PersistenceVehicle() {
        
        blanco.setEstado(Estados.DISPONIBLE);
        negro.setEstado(Estados.DISPONIBLE);
        azul.setEstado(Estados.DISPONIBLE);
        ArrayList colores = new ArrayList();
        colores.add(blanco);
        colores.add(negro);
        colores.add(azul);
        lx.setColores(colores);
        lx.setSegmento(segmentoB);
        ex.setColores(colores);
        ex.setSegmento(segmentoB);
        exs.setColores(colores);
        exs.setSegmento(segmentoB);
        exs.setPrecio(16000.00);
        fleteB.setCosto(250.00);
        patentamientoB.setCosto(exs.getPrecio());
        segmentoB.setFlete(fleteB);
        segmentoB.setPatentado(patentamientoB);
        exs.setSegmento(segmentoB);

        //mmodelos fiat
          //cronos
        cronos.getVersiones().addAll(Arrays.asList(drive,atrac,prec,cent));
          //mobi
        mobi.getVersiones().addAll(Arrays.asList(easy,like,way));
          //palio
        palio.getVersiones().addAll(Arrays.asList(esse, atrac,fire));
          //strada
        strada.getVersiones().addAll(Arrays.asList(adven, trek, work));
          //punto
        punto.getVersiones().addAll(Arrays.asList(atrac,esse, dualo));

        //modelos chevrolet
            //s10
        s10.getVersiones().addAll(Arrays.asList(x42,x44,x44H));
            //cruze
        cruze.getVersiones().addAll(Arrays.asList(ltz,lt4p,lt5p));

        //modelos honda
            //city
        city.getVersiones().addAll(Arrays.asList(lx, exl));
            //civic
        civic.getVersiones().addAll(Arrays.asList(exl,exs,lxs));
            //fit
        fit.getVersiones().addAll(Arrays.asList(lx,lxs,lxl));
            //crv
        fit.getVersiones().addAll(Arrays.asList(lx4x4,ex4x2,ex4x4));

        //modelos audi
            //a1
        a1.getVersiones().addAll(Arrays.asList(attrac,ambit, sportba));
            //a3
        a4.getVersiones().addAll(Arrays.asList(multitro,quatt,tdi1));
            //tt
        tt.getVersiones().addAll(Arrays.asList(rs,coupe1,coupe2,coupe3));
            //allroad
        allroad.getVersiones().addAll(Arrays.asList(tdi2,fsi,biturb));


        //modelos volkswagen
            //amarok
        amarok.getVersiones().addAll(Arrays.asList(com4x4,com4x2,trend4x4,high4x4,high4x2));
            //voyage
        voyage.getVersiones().addAll(Arrays.asList(comf16,trend16,high16,adv16));
            //vento
        vento.getVersiones().addAll(Arrays.asList(adv14,high14,comf14,comf16));
            //tcross
        t_cross.getVersiones().addAll(Arrays.asList(comf14manual,trend16,style16));
            //virtus
        virtus.getVersiones().addAll(Arrays.asList(comf14,comf16,adv14,high14,high16,trend16));

        //modelos bmw
            //x4
        x4.getVersiones().addAll(Arrays.asList(i20,i35,i28,i40));
            //x1
        x1.getVersiones().addAll(Arrays.asList(i25,d204x4,d204x2,i18));
            //serie4
        s4.getVersiones().addAll(Arrays.asList(i428,m4comp,m4,i430));
            //serie3
        s3.getVersiones().addAll(Arrays.asList(d320, i320, i430, i325));

        //ex.setSegmento(segmentoC);
        //exs.setSegmento(segmentoC);
       
        chevrolet.getModelos().addAll(Arrays.asList(s10,cruze));
        honda.getModelos().addAll(Arrays.asList(city,civic,crv,fit));
        fiat.getModelos().addAll(Arrays.asList(cronos,argo,punto,palio,mobi,strada));
        audi.getModelos().addAll(Arrays.asList(a1, a4, tt, allroad));
        vw.getModelos().addAll(Arrays.asList(amarok, voyage, vento,t_cross, virtus));
        bmw.getModelos().addAll(Arrays.asList(s4, x4, s3, x1));



        marcas.addAll(Arrays.asList(chevrolet, vw, honda, fiat, audi, bmw));
        
    }

    public List<String> getNombresMarcas(){
        return  marcas.stream().map(m -> m.getNombre()).collect(Collectors.toList());
    }
    
    public List<String> getNombresModelos(String marca){
        Marca marc = buscarMarca(marca);
        return marc.getModelos().stream().map(mod -> mod.getNombre()).collect(Collectors.toList());
    }
    
    public List<String> getNombresVersiones(String marca, String modelo){
        Modelo mod = buscarModelo(buscarMarca(marca), modelo);
        return mod.getVersiones().stream().map(m -> m.getNombre()).collect(Collectors.toList());
    }
    
    public List<String> getNombresColores(String marca, String modelo, String version){
        System.out.println(marca + modelo + version);
        Version ver = buscarVersion(marca, modelo, version);
        if(ver == null){
            System.out.println("NULO");
        }
        return ver.getColores().stream().map(c -> c.getNombre()).collect(Collectors.toList());
    }
    
    public Marca buscarMarca(String nombre){
        return marcas.stream().filter(m -> m.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);
    }
    public Modelo buscarModelo(Marca marca, String modelo){
        return marca.getModelos().stream().filter(m -> m.getNombre().equals(modelo))
                    .findFirst()
                    .orElse(null);
    }
    public Version buscarVersion(String marca, String modelo, String version){
        Modelo mod = buscarModelo(buscarMarca(marca), modelo);
        return mod.getVersiones().stream().filter(m -> m.getNombre().equals(version))
                    .findFirst()
                    .orElse(null);
    }
    
    public Color buscarColor(String marca, String modelo, String version, String color){
        Version ver = buscarVersion(marca, modelo, version);
        return ver.getColores().stream().filter(m -> m.getNombre().equals(color))
                    .findFirst()
                    .orElse(null);
    }
    
    public boolean isDisponible(Color color){
        return (color.getEstado().equals(Estados.DISPONIBLE)) ? true : false;
    }

    public List<Color> getColores() {
        return colores;
    }


    public void setColores(List<Color> colores) {
        this.colores = colores;
    }


    public List<Marca> getMarcas() {
        return marcas;
    }


    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }


    public List<Modelo> getModelos() {
        return modelos;
    }


    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }


    public List<Segmento> getSegmentos() {
        return segmentos;
    }


    public void setSegmentos(List<Segmento> segmentos) {
        this.segmentos = segmentos;
    }


    public List<Version> getVersiones() {
        return versiones;
    }


    public void setVersiones(List<Version> versiones) {
        this.versiones = versiones;
    }

    
    
   
    
    
    
    
}

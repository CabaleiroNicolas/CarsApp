package modelo.persistencia;

import modelo.modelos.Estados;
import modelo.modelos.Segmento;
import modelo.modelos.Modelo;
import modelo.modelos.Version;
import modelo.modelos.Marca;
import modelo.modelos.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import modelo.modelos.Cliente;
import modelo.modelos.Fecha;
import modelo.modelos.Flete;
import modelo.modelos.Patentamiento;
import modelo.modelos.Reserva;

public class Persistencia {
    
    // FLETES
    private Flete fleteA = new Flete("Rosario", 220);
    private Flete fleteB = new Flete("Buenos Aires", 250);
    private Flete fleteC = new Flete("Cordoba", 170);
    
    // PATENTAMIENTO
    private Patentamiento patentamientoA = new Patentamiento();
    private Patentamiento patentamientoB = new Patentamiento();
    private Patentamiento patentamientoC = new Patentamiento();
    
    // SEGMENTOS
    private Segmento segmentoA = new Segmento("Segmento A",fleteA,patentamientoA);
    private Segmento segmentoB = new Segmento("Segmento B",fleteB,patentamientoB);
    private Segmento segmentoC = new Segmento("Segmento C",fleteC,patentamientoC);

    // Asignación de listas de los objetos principales de la lógica de negocio
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Color> colores = new ArrayList<>();
    private List<Marca> marcas = new ArrayList<>();
    private List<Modelo> modelos = new ArrayList<>();
    private List<Segmento> segmentos = new ArrayList<>();
    private List<Version> versiones = new ArrayList<>();
    
    // MARCAS
    private Marca chevrolet = new Marca("Chevrolet");
    private Marca fiat = new Marca("Fiat");
    private Marca honda = new Marca("Honda");
    private Marca audi = new Marca("Audi");
    private Marca vw = new Marca("Volkswagen");
    private Marca bmw = new Marca("BMW");

    // MODELOS
        // fiat
    private Modelo cronos = new Modelo("Cronos");
    private Modelo argo = new Modelo("Argo");
    private Modelo mobi = new Modelo("Mobi");
    private Modelo palio = new Modelo("Palio");
    private Modelo punto = new Modelo("Punto");
    private Modelo strada = new Modelo("Strada");
        // chevrolet
    private Modelo cruze = new Modelo("Cruze");
    private Modelo s10 = new Modelo("S10");
        // honda
    private Modelo fit = new Modelo("Fit");
    private Modelo crv = new Modelo("CRV");
    private Modelo city = new Modelo("City");
    private Modelo civic = new Modelo("Civic");
        // audi
    private Modelo a1 = new Modelo("A1");
    private Modelo a4 = new Modelo("A4");
    private Modelo tt = new Modelo("TT");
    private Modelo allroad = new Modelo("AllRoad");
        // volkswagen
    private Modelo amarok = new Modelo("Amarok"); //camioneta
    private Modelo voyage = new Modelo("Voyage");
    private Modelo t_cross = new Modelo("T-Cross");
    private Modelo vento = new Modelo("Vento");
    private Modelo virtus = new Modelo("Virtus");
        // BMW
    private Modelo x4 = new Modelo("X4");
    private Modelo x1 = new Modelo("X1");
    private Modelo s4 = new Modelo("Serie 4");
    private Modelo s3 = new Modelo("Serie 3");

    // VERSIONES
        // fiat 
    private Version atrac = new Version("1.3 Attractive MT (99cv)", segmentoA, 26000.00);
    private Version drive = new Version("1.3 Drive MT (99cv)", segmentoA, 26500.00);
    private Version prec = new Version("Precision CVT (99cv)", segmentoB, 30000.00);
    private Version cent = new Version("Centenario SL (130cv)", segmentoB, 33000.00);
    private Version easy = new Version("1.0 Easy (75cv)", segmentoA, 25000.00);
    private Version like = new Version("1.0 Like (75cv)", segmentoA, 25500.00);
    private Version way = new Version("1.0 Way Live On (75cv)", segmentoA, 25800.00);
    private Version esse = new Version("Essence 1.6 5Ptas. (115cv)", segmentoB, 28500.00);
    private Version fire = new Version("Fire 1.3 3Ptas.", segmentoA, 25000.00);
    private Version adven = new Version("Adventure 1.8 Extreme", segmentoC, 32000.00);
    private Version trek = new Version("Trekking 1.3 JDT", segmentoC, 31500.00);
    private Version work = new Version("Working 1.4 Serie", segmentoC, 25500.00);
    private Version dualo = new Version("Dualogic 5Ptas. (115cv)", segmentoC, 29000.00);
        // chevrolet
    private Version x44 = new Version("2.8 4x4 (200cv)", segmentoC, 34500);
    private Version x42 = new Version("2.8 4x2 (180cv)", segmentoC, 32000);
    private Version x44H = new Version("2.8 4x4 HIGH Country (210cv)", segmentoC, 36500);
    private Version lt4p = new Version("LT MT (141cv) 4Ptas.", segmentoB, 28000);
    private Version lt5p = new Version("LT MT (141cv) 5Ptas.", segmentoB, 28500);
    private Version ltz = new Version("LTZ (141cv) 4Ptas.", segmentoB, 29500);
        // honda
    private Version exl = new Version("EXL MT ABS Cuero (120cv)", segmentoB, 32000);
    private Version lx = new Version("LX MT 2ABS (120cv)", segmentoB, 22000); // Ya definido, manteniendo el precio
    private Version exs = new Version("EXS Sedán (140cv)", segmentoB, 25000); // Ya definido, manteniendo el precio
    private Version lxs = new Version("LXS AT Sedán (154cv)", segmentoB, 33000);
    private Version lxl = new Version("LXL AT IVTEC (120cv)", segmentoB, 31500);
    private Version ex = new Version("EX MT IVTEC", segmentoB, 30000);
    private Version ex4x4 = new Version("EX 4X4 (185cv)", segmentoC, 37000);
    private Version ex4x2 = new Version("EX 4X2 (170cv)", segmentoC, 34000);
    private Version lx4x4 = new Version("LX 4X4 (185cv)", segmentoC, 36000);
        // audi
    private Version ambit = new Version("Ambition (122cv)", segmentoB, 35000);
    private Version attrac = new Version("MT Atraction (86cv)", segmentoA, 35000);
    private Version sportba = new Version("Sportback 1.4 TFSI (185cv)", segmentoB, 38000);
    private Version multitro = new Version("Multitronic Sport (140cv)", segmentoB, 36000);
    private Version tdi1 = new Version("TDI MT Plus (143cv)", segmentoB, 37000);
    private Version quatt = new Version("TFSI Quattro (225cv)", segmentoB, 39000);
    private Version coupe2 = new Version("Coupé 2.0 MT (211cv)", segmentoB, 37500);
    private Version coupe1 = new Version("Coupé 1.8T Sport (160cv)", segmentoB, 35000);
    private Version coupe3 = new Version("Coupé 3.2 V6 MT (250cv)", segmentoB, 40000);
    private Version rs = new Version("RS 2.5T FSI (340cv)", segmentoB, 40000);
    private Version fsi = new Version("FSI (255cv)", segmentoC, 38000); // camioneta
    private Version tdi2 = new Version("2.7 TDI (233cv)", segmentoC, 39000); // camioneta
    private Version biturb = new Version("2.7 Biturbo Tiptronic", segmentoC, 40000); // camioneta

        // volkswagen
    private Version trend4x4 = new Version("2.0 4X4 Trendline (140cv)",segmentoC,35000);//camioneta
    private Version high4x4 = new Version("2.0 4X4 Highline (163cv)", segmentoC,43000);//camioneta
    private Version high4x2 = new Version("2.0 4X2 Highline (163cv)",segmentoC, 37000);//camioneta
    private Version com4x4 = new Version("2.0 4X4 Comfortline (180cv)",segmentoC, 33000);//camioneta
    private Version com4x2 = new Version("2.0 4X2 Comfortline (170cv)",segmentoC, 31000);//camioneta
    private Version comf16 = new Version("1.6 Comfortline (101cv)",segmentoB, 27000);
    private Version high16 = new Version("1.6 Highline (101cv)", segmentoB, 29000);
    private Version trend16 = new Version("1.6 Trendline (101cv)",segmentoA, 25000);
    private Version adv16 = new Version("1.6 Advance (101cv)",segmentoA, 27000);
    private Version adv14 = new Version("1.4 TSI Advance (101cv)",segmentoB,25500);
    private Version high14 = new Version("1.4 AT Highline (150cv)",segmentoB, 28000);
    private Version comf14 = new Version("1.4 TSI Comfortline (150cv)",segmentoB, 26000);
    private Version comf14manual = new Version("1.4 MSI Comfortline Manual",segmentoA, 24000);
    private Version style16 = new Version("1.6 Style Edition",segmentoB, 28000);
        // BMW
    private Version i20 = new Version("20i xDrive Active (184cv)", segmentoA, 30000.00);
    private Version i28 = new Version("28i xDrive xLine (245cv)", segmentoA, 32000.00);
    private Version i35 = new Version("35i xDrive M Package (306cv)", segmentoB, 37000.00);
    private Version i40 = new Version("xDrive M40i (354cv)", segmentoB, 28000.00);
    private Version i18 = new Version("18i sDrive Advantage (140cv)", segmentoA, 19000.00);
    private Version d204x4 = new Version("20d xDrive Active AT 4X4 (177cv)", segmentoC, 45000.00);//camioneta
    private Version d204x2 = new Version("20d xDrive Active MT 4X2 (177cv)", segmentoC, 50000.00);//camioneta
    private Version i25 = new Version("25i xDrive xLine (204cv)", segmentoC, 48000.00);//camioneta
    private Version i430 = new Version("430i Coupé M Sport Package (258cv)", segmentoB, 25000.00);
    private Version i428 = new Version("428i Coupé Sport Line (245cv)", segmentoB, 36500.00);
    private Version m4comp = new Version("M4 Competition Coupé (510cv) (L23)", segmentoB, 41000.00);
    private Version m4 = new Version("M4 Coupé (431cv)", segmentoB, 40500.00);
    private Version d320 = new Version("320d Sedán Executive (184cv) (L09)", segmentoA, 35500.00);
    private Version i320 = new Version("320i Sedán Active (156cv)", segmentoB, 36000.00);
    private Version i325 = new Version("325i Cabrio Pack M (L09)", segmentoB, 33000.00);
    
    public Persistencia() {
        
        clientes.add(new Cliente("44978725", "Leon Breslauer",
                "Hola 123", "leon.breslauer@alu.frt.utn.edu.ar",
                "3811234567", "3171234"));
        clientes.add(new Cliente("44123456", "Lionel Messi",
                "Hola 456", "lionel.messi@alu.frt.utn.edu.ar",
                "3814567891", "3179876"));
        clientes.add(new Cliente("45124671", "Matias Alderete",
                "Hola 123", "Gustavo.alderete@alu.frt.utn.edu.ar",
                "3812345678", "123456"));
        clientes.add(new Cliente("44580815", "Nicolas Cabaleiro",
                "Hola 456", "nicolas.cabaleiro@alu.frt.utn.edu.ar",
                "3811214125", "1425152"));
        clientes.add(new Cliente("41383873", "Ivan Ochoa",
                "Hola 456", "ivan.ochoa@alu.frt.utn.edu.ar",
                "3811214125", "1425152"));
        
        
        
        // Asignamos precio y fecha de entrega del vehículo
            // VERSION exs honda
        exs.setFechaEntrega(new Fecha(24,6,2024));
            // VERSION lx honda
        lx.setFechaEntrega(new Fecha(25,6,2024));
        
        // Asignamos una lista de versiones por cada modelo creado anteriormente
        
        // MODELOS fiat
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

        // MODELOS chevrolet
            //s10
        s10.getVersiones().addAll(Arrays.asList(x42,x44,x44H));
            //cruze
        cruze.getVersiones().addAll(Arrays.asList(ltz,lt4p,lt5p));

        // MODELOS honda
            //city
        city.getVersiones().addAll(Arrays.asList(lx, exl));
            //civic
        civic.getVersiones().addAll(Arrays.asList(exl,exs,lxs));
            //fit
        fit.getVersiones().addAll(Arrays.asList(lx,lxs,lxl));
            //crv
        crv.getVersiones().addAll(Arrays.asList(lx4x4,ex4x2,ex4x4));

        // MODELOS audi
            //a1
        a1.getVersiones().addAll(Arrays.asList(attrac,ambit, sportba));
            //a3
        a4.getVersiones().addAll(Arrays.asList(multitro,quatt,tdi1));
            //tt
        tt.getVersiones().addAll(Arrays.asList(rs,coupe1,coupe2,coupe3));
            //allroad
        allroad.getVersiones().addAll(Arrays.asList(tdi2,fsi,biturb));
        
        // MODELOS volkswagen
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

        // MODELOS bmw
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
       
       // Asignamos una lista de modelos por cada marca creada anteriormente
        chevrolet.getModelos().addAll(Arrays.asList(s10,cruze));
        honda.getModelos().addAll(Arrays.asList(city,civic,crv,fit));
        fiat.getModelos().addAll(Arrays.asList(cronos,punto,palio,mobi,strada));
        audi.getModelos().addAll(Arrays.asList(a1, a4, tt, allroad));
        vw.getModelos().addAll(Arrays.asList(amarok, voyage, vento,t_cross, virtus));
        bmw.getModelos().addAll(Arrays.asList(s4, x4, s3, x1));

        // Asignamos la lista de marcas disponibles en esta aplicación
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
        return (color.getEstado().equals(Estados.DISPONIBLE));
    }
    
    public List<Reserva> getReservas() {
        return reservas;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
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

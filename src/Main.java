import java.util.Arrays;
public class Main{
    public static int ceaMaiIeftinaTastatura(int[]preturiTastaturi){
        Arrays.sort(preturiTastaturi);
        return preturiTastaturi[0];
    }
    public static int celMaiScumpObiect(int[]preturiTastaturi, int[]preturiUSB){
        int pretMaxTastatura=-1;
        int pretMaxUSB=-1;
        for (int pret:preturiTastaturi){
            if(pret>pretMaxTastatura){
                pretMaxTastatura=pret;
            }
        }
        for(int pret:preturiUSB){
            if(pret>pretMaxUSB){
                pretMaxUSB=pret;
            }
        }
        return Math.max(pretMaxTastatura, pretMaxUSB);
    }
    public static int celMaiScumpUSBPermis(int[]preturiUSB, int buget){
        Arrays.sort(preturiUSB);
        int pretMaximUSB=0;
        for(int pret : preturiUSB){
            if (pret<=buget){
                pretMaximUSB=pret;
            }
        }
        return pretMaximUSB;
    }
    public static int calculCostTotal(int buget, int[] preturiTastaturi, int[]preturiUSB){
        Arrays.sort(preturiTastaturi);
        Arrays.sort(preturiUSB);
        int pretMaximTastatura=0;
        int pretMaximUSB=0;
        for(int pret:preturiTastaturi){
            if(pret<=buget){
                pretMaximTastatura=pret;
            }
        }
        for(int pret: preturiUSB){
            if(pret<=(buget-pretMaximTastatura)){
                pretMaximUSB=pret;
            }
        }
        if (pretMaximTastatura==0 || pretMaximUSB==0){
            return -1;
        }
        return pretMaximTastatura+pretMaximUSB;
    }
    public static void testCeaMaiIeftinaTastatura() {
        int[] preturiTastaturi = {40, 35, 70, 15, 45};
        int expected = 15;
        int result = ceaMaiIeftinaTastatura(preturiTastaturi);
        assert expected == result;
    }

    public static void testCelMaiScumpObiect() {
        int[] preturiTastaturi = {40, 35, 70, 15, 45};
        int[] preturiUSB = {20, 15, 40, 15};
        int expected = 70;
        int result = celMaiScumpObiect(preturiTastaturi, preturiUSB);
        assert expected == result;
    }

    public static void testCelMaiScumpUSBPermis() {
        int[] preturiUSB = {20, 15, 40, 15};
        int buget = 60;
        int expected = 40;
        int result = celMaiScumpUSBPermis(preturiUSB, buget);
        assert expected == result;
    }

    public static void testCalculCostTotal() {
        int[] preturiTastaturi = {40, 35, 70, 15, 45};
        int[] preturiUSB = {20, 15, 40, 15};
        int buget = 60;
        int expected = 60;
        int result = calculCostTotal(buget, preturiTastaturi, preturiUSB);
        assert expected == result;

        int[] preturiTastaturi2 = {80, 90, 100};
        int[] preturiUSB2 = {70, 80, 90};
        int buget2 = 60;
        int unexpected = -1;
        int resultUnexpected = calculCostTotal(buget2, preturiTastaturi2, preturiUSB2);
        assert unexpected == resultUnexpected;
    }
    public static void main(String[]args){
        int[]preturiTastaturi={40, 35, 70, 15, 45};
        int[]preturiUSB={20, 15, 40, 15};
        int buget=60;
        testCeaMaiIeftinaTastatura();
        testCelMaiScumpObiect();
        testCelMaiScumpUSBPermis();
        testCalculCostTotal();
        int rp1=ceaMaiIeftinaTastatura(preturiTastaturi);
        System.out.println("Cea mai ieftina tastatura: "+rp1);

        int rp2=celMaiScumpObiect(preturiTastaturi, preturiUSB);
        System.out.println("Cel mai scump obiect: "+rp2);

        int rp3=celMaiScumpUSBPermis(preturiUSB, buget);
        System.out.println("Cel mai scump USB permis: "+rp3);

        int rp4=calculCostTotal(buget, preturiTastaturi, preturiUSB);
        if(rp4==-1){
            System.out.println("Markus nu poate cumpara ambele obiecte");
        }else{
            System.out.println("Costul total: "+rp4);
        }
    }
}
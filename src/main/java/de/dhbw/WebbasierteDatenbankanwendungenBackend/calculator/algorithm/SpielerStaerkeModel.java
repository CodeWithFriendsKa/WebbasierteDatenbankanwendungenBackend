package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm;

enum SpielerStaerkeModel {
    //Hier wird eine Variable erstell mit der die Berechnung der Spielerstärke vereinfacht wird
    NICHTVORHANDEN( null ),BRONZE( -2 ), IRON( -1 ), SILBER( 0 ), GOLD( 1 ), DIAMANT( 2 );
    private final Integer staerke;
    SpielerStaerkeModel(Integer staerke ) { this.staerke = staerke; }
    public static SpielerStaerkeModel valueOf(Integer spielerStaerke) {
        if(spielerStaerke == null)return NICHTVORHANDEN;
        if(spielerStaerke == 2)return DIAMANT;
        if(spielerStaerke == -2)return BRONZE;
        if(spielerStaerke == -1)return IRON;
        if(spielerStaerke == 0)return SILBER;
        if(spielerStaerke == 1)return GOLD;
        return NICHTVORHANDEN;
    }
    public Integer Staerke() {
        return staerke;
    }

}
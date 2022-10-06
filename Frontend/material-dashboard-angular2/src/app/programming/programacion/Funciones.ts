export class Funciones{

    constructor(){}


    getCurrentDate(): string{
        let fecha_actual = new Date();
        let fecha = fecha_actual.toLocaleDateString();
        return fecha;
    }



    getCurrentTime(): string{
        let hora_actual = new Date();
        return hora_actual.toLocaleTimeString();
    }




}
import { Medicamento } from "./Medicamento.dto";

export class Cliente{

    id_cliente: number;
    nombre_cliente: string;
    apellido_paterno_cliente: string;
    apellido_materno_cliente: string;
    edad_cliente: number;
    medicamentos: Medicamento[];

}
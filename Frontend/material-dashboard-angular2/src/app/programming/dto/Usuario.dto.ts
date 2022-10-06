import { Cliente } from "./Cliente.dto";

export class Usuario{

    id_usuario: number;
    nombre_usuario: string;
    correo_usuario: string;
    clave_usuario: string;
    cliente: Cliente;


    constructor(){}
}
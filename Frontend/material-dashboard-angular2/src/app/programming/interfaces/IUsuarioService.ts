import { Observable } from "rxjs";
import { Response } from "../models/Response.dto";

export interface IUsuarioService<T>{

    getAll(): Observable<Response<T[]>>;

    createOrUpdate(entity: T): Observable<Response<T>>;

    accesoExitoso(usuario: string, correo: string, clave: string): Observable<Response<T>>;

    recuperarContraseña(usuario: string, correo: string): Observable<Response<T>>;


}
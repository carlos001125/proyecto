import { Observable } from "rxjs";
import { Response } from "../models/Response.dto";

export interface IMedicamentoService<T>{

    getAll(): Observable<Response<T[]>>;

    getById(id: number): Observable<Response<T>>;

    createOrUpdate(entity: T): Observable<Response<T>>;

    deleteById(id: number): Observable<Response<T>>;

}
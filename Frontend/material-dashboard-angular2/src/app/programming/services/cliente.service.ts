import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../dto/Cliente.dto';
import { IClienteService } from '../interfaces/IClienteService';
import { Response } from '../models/Response.dto';

@Injectable({
  providedIn: 'root'
})
export class ClienteService implements IClienteService<Cliente>{

  getAllUrl: string = "http://localhost:8084/api/proyecto/clientes/getAll";
  getByIdUrl: string = `http://localhost:8084/api/proyecto/clientes/getById`; // aqui falta el id
  createOrUpdateUrl: string = `http://localhost:8084/api/proyecto/clientes/createOrUpdate`;
  deleteByIdUrl: string = `http://localhost:8084/api/proyecto/clientes/deleteById`; // aqui falta el id

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Response<Cliente[]>> {
    return this.httpClient.get<Response<Cliente[]>>(`${this.getAllUrl}`);
  }
  getById(id: number): Observable<Response<Cliente>> {
    return this.httpClient.get<Response<Cliente>>(`${this.getByIdUrl}/${id}`);
  }
  createOrUpdate(entity: Cliente): Observable<Response<Cliente>> {
    return this.httpClient.post<Response<Cliente>>(`${this.createOrUpdateUrl}`, entity);
  }
  deleteById(id: number): Observable<Response<Cliente>> {
    return this.httpClient.delete<Response<Cliente>>(`${this.deleteByIdUrl}/${id}`);
  }


}

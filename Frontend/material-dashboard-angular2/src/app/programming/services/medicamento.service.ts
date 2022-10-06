import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medicamento } from '../dto/Medicamento.dto';
import { IMedicamentoService } from '../interfaces/IMedicamentoService';
import { Response } from '../models/Response.dto';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MedicamentoService implements IMedicamentoService<Medicamento>{

  constructor(private httpClient: HttpClient) { }

  getAllUrl: string = "http://localhost:8084/api/proyecto/medicamentos/getAll";
  getByIdUrl: string = `http://localhost:8084/api/proyecto/medicamentos/getById`; // aqui falta el id
  createOrUpdateUrl: string = `http://localhost:8084/api/proyecto/medicamentos/createOrUpdate`;
  deleteByIdUrl: string = `http://localhost:8084/api/proyecto/medicamentos/deleteById`; // aqui falta el id


  getAll(): Observable<Response<Medicamento[]>> {
    return this.httpClient.get<Response<Medicamento[]>>(`${this.getAllUrl}`);
  }
  getById(id: number): Observable<Response<Medicamento>> {
    return this.httpClient.get<Response<Medicamento>>(`${this.getByIdUrl}/${id}`);
  }
  createOrUpdate(entity: Medicamento): Observable<Response<Medicamento>> {
    return this.httpClient.post<Response<Medicamento>>(`${this.createOrUpdateUrl}`, entity);
  }
  deleteById(id: number): Observable<Response<Medicamento>> {
    return this.httpClient.delete<Response<Medicamento>>(`${this.deleteByIdUrl}/${id}`);
  }
}

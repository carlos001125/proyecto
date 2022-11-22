import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../dto/Usuario.dto';
import { IUsuarioService } from '../interfaces/IUsuarioService';
import { Response } from '../models/Response.dto';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService implements IUsuarioService<Usuario>{

  constructor(private httpClient: HttpClient) { }
 
  baseUrl: string = environment.baseUrl
  getAllUrl: string = `${this.baseUrl}/api/proyecto/usuarios/getAll`;
  createOrUpdateUrl: string = `${this.baseUrl}/api/proyecto/usuarios/createOrUpdate`;
  getUserWithData: string = "${this.baseUrl}/api/proyecto/usuarios/getUserAccess";
  rescueAccount: string = `${this.baseUrl}/api/proyecto/usuarios/getUserRescue`;

  getAll(): Observable<Response<Usuario[]>> {
    return this.httpClient.get<Response<Usuario[]>>(`${this.getAllUrl}`);
  }
  createOrUpdate(entity: Usuario): Observable<Response<Usuario>> {
    return this.httpClient.post<Response<Usuario>>(`${this.createOrUpdateUrl}`, entity);
  }
  accesoExitoso(usuario: string, correo: string, clave: string): Observable<Response<Usuario>> {
    return this.httpClient.get<Response<Usuario>>(`${this.getUserWithData}/${usuario}/${correo}/${clave}`);
  }

  recuperarContraseña(usuario: string, correo: string): Observable<Response<Usuario>> {
    return this.httpClient.get<Response<Usuario>>(`${this.rescueAccount}/${usuario}/${correo}`);
  }
}

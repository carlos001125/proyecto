import { Injectable } from '@angular/core';
import { Cliente } from '../dto/Cliente.dto';

@Injectable({
  providedIn: 'root'
})
export class AuxiliarService {

  clienteActivo: Cliente = new Cliente();

  constructor() { }


}

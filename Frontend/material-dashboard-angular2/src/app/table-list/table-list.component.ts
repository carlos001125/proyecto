import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Cliente } from 'app/programming/dto/Cliente.dto';
import { Medicamento } from 'app/programming/dto/Medicamento.dto';
import { AuxiliarService } from 'app/programming/services/auxiliar.service';
import { ClienteService } from 'app/programming/services/cliente.service';


@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {

  cliente_activo: Cliente;
  medicamentos_de_cliente_activo: Medicamento[];
  nombre_cliente_activo: string;
  apellido1_cliente_activo: string;

  constructor(private clienteService: ClienteService,
    private AuxiliarService: AuxiliarService,
    private router: Router) { }

  ngOnInit() {

    let cliente: Cliente = JSON.parse(localStorage.getItem('cliente'));
    this.listAllMedicamentosByClienteId(cliente.id_cliente);

  }

  toGoCreate(): void{
    this.router.navigate(['/user-profile']);
  }

  sonarPrueba(): void{
    const audio = new Audio();
    audio.src = "../assets/sonidos/tonoPrueba1.wav";
    audio.crossOrigin = "anonymous"
    audio.load();
    audio.play();
  }

  listAllMedicamentosByClienteId(id_cliente: number): void{
    this.clienteService.getById(id_cliente).
      subscribe( resp => {
        this.medicamentos_de_cliente_activo = resp.body.medicamentos;
        this.nombre_cliente_activo = resp.body.nombre_cliente;
        this.apellido1_cliente_activo = resp.body.apellido_paterno_cliente;
      }, error =>{

      })
  }
}

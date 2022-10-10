import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Medicamento } from 'app/programming/dto/Medicamento.dto';
import { Cliente_Medicamento } from 'app/programming/dto/Cliente_Medicamento.dto';
import { MedicamentoService } from 'app/programming/services/medicamento.service';
import { Cliente } from 'app/programming/dto/Cliente.dto';
import { ClienteMedicamentoService } from 'app/programming/services/cliente-medicamento.service';
import { Funciones } from 'app/programming/programacion/Funciones';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  // para el formulario reactivo principal

  cliente_medicamentos_form: FormGroup;

  // medicamentos que llenan el combobox (vienen del API)
  medicamentos: Medicamento[] = [];
  medicamentos_seleccionados: Medicamento[] = [];
  cliente_iniciado: Cliente = new Cliente();

  get form() {
    return this.cliente_medicamentos_form.controls;
  }

  constructor(private medicamentoService: MedicamentoService,
    private clienteMedicamentoService: ClienteMedicamentoService,
    private formBuilder: FormBuilder,
    private router: Router) { }



  ngOnInit() {

    const funciones: Funciones = new Funciones();
    
    this.cliente_iniciado = JSON.parse(localStorage.getItem('cliente'));
    this.cliente_medicamentos_form = this.formBuilder.group({
      id_cliente_medicamento: [null],
      id_cliente: [this.cliente_iniciado.id_cliente, [Validators.required]],
      id_medicamento: ['', Validators.required],
      completado_medicamento: [false, [Validators.required]],
      hora_medicacion: ['', [Validators.required]],
      fecha_medicacion: ['', [Validators.required]]
    });

    this.listAllMedicamentos();
  }

  addMedicamentoToDb(id_medicamento: number): void{
    console.log("Agregando el medicamento: " + id_medicamento);

    let medicamento_seleccionado: Cliente_Medicamento = this.cliente_medicamentos_form.value;
    medicamento_seleccionado.id_medicamento = id_medicamento;

    this.clienteMedicamentoService.createOrUpdate(medicamento_seleccionado)
      .subscribe(resp =>{
        console.log(resp.body);
        this.addMedicamentoToTable(id_medicamento)
      }, error => {
        console.log(error);
        Swal.fire("Error en API", "Ocurrio un error interno al registrar el medicamento", "error");
      })

    console.log(JSON.stringify(this.cliente_medicamentos_form.value));
  }

  addMedicamentoToTable(id_medicamento: number): void{
    this.medicamentoService.getById(id_medicamento)
      .subscribe(resp =>{
        this.medicamentos_seleccionados.push(resp.body);
      }, error =>{
        console.log("Error");
        Swal.fire("Error", "Error de API", "error");
      })
  }

  findIndexMedicamentoById(id_medicamento: number): number{
    return this.medicamentos_seleccionados.findIndex(medSeleccionado => medSeleccionado.id_medicamento === id_medicamento);
  }

  deleteMedicamentoFromTable(id_medicamento: number): void{
    this.medicamentos_seleccionados.splice(this.findIndexMedicamentoById(id_medicamento), 1);
  }

  listAllMedicamentos(): void {
    this.medicamentoService.getAll().
      subscribe(resp => {
        this.medicamentos = resp.body;
      }, error => {

      })
  }

  onSubmit(): void {
    this.router.navigate(['/table-list']);
  }

}

import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cliente } from 'app/programming/dto/Cliente.dto';
import { Usuario } from 'app/programming/dto/Usuario.dto';
import { ClienteService } from 'app/programming/services/cliente.service';
import { UsuarioService } from 'app/programming/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-typography',
  templateUrl: './typography.component.html',
  styleUrls: ['./typography.component.css']
})
export class TypographyComponent implements OnInit {

  clienteForm: FormGroup;
  clienteCreado: Cliente = new Cliente();
  usuarioForm: FormGroup;

  get cliente() {
    return this.clienteForm.controls;
  }

  get usuario() {
    return this.usuarioForm.controls;
  }

  constructor(private formBuilder: FormBuilder, private clienteService: ClienteService,
    private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit() {

    this.clienteForm = this.formBuilder.group({
      id_cliente: [null],
      nombre_cliente: ['', [Validators.required]],
      apellido_paterno_cliente: ['', [Validators.required]],
      apellido_materno_cliente: ['', [Validators.required]],
      edad_cliente: ['', [Validators.required]],
      medicamentos: new FormArray([])
    });

    this.usuarioForm = this.formBuilder.group({
      id_usuario: [null],
      nombre_usuario: ['', [Validators.required]],
      correo_usuario: ['', [Validators.required]],
      clave_usuario: ['', [Validators.required]],
      cliente: new Cliente()
    });

  }


  onSubmitCliente(): void {
    const cliente: Cliente = this.clienteForm.value;
    console.log(cliente);
    this.clienteService.createOrUpdate(cliente).subscribe(resp => {
      console.log(resp.body);
      this.clienteCreado = resp.body;
      Swal.fire("Cliente agregado", "", "success")
    }, error => {
      Swal.fire("Error", "Error interno al crear", "error")
    })
  }

  onSubmitUsuario(): void{
    const usuarioACrear: Usuario = this.usuarioForm.value;
    usuarioACrear.cliente = this.clienteCreado;
    this.usuarioService.createOrUpdate(usuarioACrear).subscribe(resp => {
      console.log(resp.body);
      Swal.fire("Registrado", "Registrado exitosamente", "success");
      this.router.navigate(['/notifications']);
    }, error =>{
      Swal.fire("Error en api", "Hubo un error al llamar a la api de registro", "error");
      console.log(error);
    });
  }

}

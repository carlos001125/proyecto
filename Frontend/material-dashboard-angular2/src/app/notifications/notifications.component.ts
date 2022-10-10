import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { Cliente } from 'app/programming/dto/Cliente.dto';
import { AuxiliarService } from 'app/programming/services/auxiliar.service';
import { UsuarioService } from 'app/programming/services/usuario.service';
import Swal from 'sweetalert2'

declare var $: any;
@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  showNotification(from, align){
    const type = ['','info','success','warning','danger'];

    const color = Math.floor((Math.random() * 4) + 1);

    $.notify({
        icon: "notifications",
        message: "Welcome to <b>Material Dashboard</b> - a beautiful freebie for every web developer."

    },{
        type: type[color],
        timer: 4000,
        placement: {
            from: from,
            align: align
        },
        template: '<div data-notify="container" class="col-xl-4 col-lg-4 col-11 col-sm-4 col-md-4 alert alert-{0} alert-with-icon" role="alert">' +
          '<button mat-button  type="button" aria-hidden="true" class="close mat-button" data-notify="dismiss">  <i class="material-icons">close</i></button>' +
          '<i class="material-icons" data-notify="icon">notifications</i> ' +
          '<span data-notify="title">{1}</span> ' +
          '<span data-notify="message">{2}</span>' +
          '<div class="progress" data-notify="progressbar">' +
            '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
          '</div>' +
          '<a href="{3}" target="{4}" data-notify="url"></a>' +
        '</div>'
    });
}

  usuarioForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private usuarioService: UsuarioService,
    private AuxiliarService: AuxiliarService, 
    private router: Router) { }

  ngOnInit() {
    
    localStorage.removeItem('cliente');

    this.usuarioForm = this.formBuilder.group({
      nombre_usuario: [''],
      correo_usuario: [''],
      clave_usuario: [''],
    });
  }

  guardaClienteEnLocalStorage(cliente: Cliente): void{
    localStorage.setItem('cliente', JSON.stringify(cliente));
  }

  guardaCliente(cliente: Cliente): void{
    this.AuxiliarService.clienteActivo = cliente;
    this.guardaClienteEnLocalStorage(cliente);
    console.log(this.AuxiliarService.clienteActivo);
  }


  toGoToForgot(): void{
    this.router.navigate(['/maps']);
  }

  toGoRegister(): void{
    this.router.navigate(['/typography']);
  }


  onSubmit(): void{
    const nombre: string = this.usuarioForm.controls['nombre_usuario'].value;
    const correo: string = nombre;
    const clave: string = this.usuarioForm.controls['clave_usuario'].value;

    this.usuarioService.accesoExitoso(nombre, correo, clave)
      .subscribe(resp =>{
        
        const usuario = resp.body;
        if(usuario === null){
          Swal.fire("Acceso denegado", "Los datos de inicio son incorrectos", "error");
          // console.log(resp.body);
        }else{
          Swal.fire("Accediendo", "", "success");
          this.guardaCliente(usuario.cliente);
          this.router.navigate(['/table-list']);
          // console.log(resp.body)
        }

      }, error =>{
        Swal.fire("Error", "Error en API", "error");
        console.log(error);
      })
  }

}

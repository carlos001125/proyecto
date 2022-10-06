import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'app/programming/services/usuario.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.css']
})
export class MapsComponent implements OnInit {

  usuario_o_correo: string = ""; 

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {

    
  }


  recuperarClave(): void{
    if(this.usuario_o_correo === ""){
        Swal.fire("Debe escribir el correo o usuario", "", "warning");
    }else{
        const usuario_correo = this.usuario_o_correo;
        this.usuarioService.recuperarContraseña(usuario_correo, usuario_correo)
            .subscribe(response =>{

                const usuario_a_recuperar = response.body;
                if(usuario_a_recuperar === null){
                    Swal.fire("Sin datos", `No se encontro registro con los siguientes datos: ${usuario_correo}`, "question");
                }else{
                    Swal.fire("Recuperacion exitosa", `Su contraseña es: ${usuario_a_recuperar.clave_usuario}`, "success");
                }

            }, error =>{
                Swal.fire("Error en api", "Ocurrio un error interno de sistema", "error");
                console.log(error)
            })
    }
  }


}

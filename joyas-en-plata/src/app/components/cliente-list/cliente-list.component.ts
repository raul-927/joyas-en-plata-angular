import { Component, HostBinding, Input, OnInit } from '@angular/core';
import {Cliente} from '../../domains/Cliente';
import {ClienteService } from '../../services/cliente.service';
@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css'],

})
export class ClienteListComponent implements OnInit {

    @HostBinding('attr.class') cssClass = 'row';

     @Input() cliente: Cliente;
  constructor() { }

  // voteUp() {
  //   this.cliente.voteUp();
  // }

  // voteDown() {
  //   this.cliente.voteDown();
  // }
  ngOnInit() {
    console.log('######################################');
    console.log('Nombre: ' + this.cliente.nombre);
    console.log('Apellido: ' + this.cliente.apellido);
    console.log('Cedula: ' + this.cliente.cedula);
    console.log('Ocupacion: ' + this.cliente.ocupacion);
  }

}

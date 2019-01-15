import { Component, OnInit } from '@angular/core';
import {ClienteService} from '../../services/cliente.service';
import {Cliente} from '../../domains/Cliente';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clientes: Cliente[];
  constructor(private clienteService: ClienteService) {

   }

  ngOnInit() {
     this.clienteService.getClientes().subscribe(result => {
      this.clientes = result;
     });
  }

}

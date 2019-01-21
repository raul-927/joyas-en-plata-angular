import { Component, OnInit} from '@angular/core';
import {ClienteService} from '../../services/cliente.service';
import {Cliente} from '../../domains/Cliente';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css'],
  providers: [ClienteService]
})
export class ClienteComponent implements OnInit {
  title = 'ClientePrueba';
  clientes: Cliente[];
  cliente: Cliente;

  public formCliente: FormGroup;
  constructor(private clienteService: ClienteService) {

  }

  ngOnInit() {
    this.clienteService.getClientes().subscribe(data => {
      this.clientes = data;
      console.log('Datos: ' + JSON.stringify(data));
    });

     this.formCliente = new FormGroup({
      id: new FormControl(''),
      nombre: new FormControl(''),
      apellido: new FormControl(''),
      cedula: new FormControl('')
     });
  }
  public onClick() {
    console.log('Click aqui');
    return false;
  }

  prueba(form: any): void {
    console.log('you submitted value:', form);
  }

  public insertClientes(cliente: NgForm) {
    console.log('ClientesForm: ' + JSON.stringify(this.formCliente.value));
    console.log('Cliente: ' + JSON.stringify(cliente));
    this.clienteService.save(cliente).subscribe(result => {
    this.cliente = result;
    console.log('Save: ' + JSON.stringify(result));
    }, error => console.error(error));
    cliente = null;
    this.clienteService.getClientes().subscribe(data => {
      this.clientes = data;
      console.log('Datos: ' + JSON.stringify(data));
    });
    return false;

  }

  // sortedArticles(): Cliente[] {
  //   return this.clientes.sort((a: Cliente, b: Cliente) => b.votes - a.votes);
  // }
}

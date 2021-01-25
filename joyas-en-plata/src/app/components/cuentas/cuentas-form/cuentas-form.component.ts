import { Component, OnInit, OnChanges} from '@angular/core';
import {CuentasService} from '../../../services/cuentas.service';
import {GrupoCuentasService} from '../../../services/grupo-cuentas.service';
import {GrupoCuentas} from '../../../domains/GrupoCuentas';
import {Cuentas} from '../../../domains/Cuentas';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { NgForm } from '@angular/forms';
import {TipoCuenta} from '../../../enums/TipoCuenta';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-cuentas-form',
  templateUrl: './cuentas-form.component.html',
  styleUrls: ['./cuentas-form.component.css']
})
export class CuentasFormComponent implements OnInit, OnChanges {

  cuenta: Cuentas;
  cuentas: Cuentas[];

  grupoCuenta: GrupoCuentas;
  grupoCuentas: GrupoCuentas[];
  // cambio: boolean;
  formCuentas: FormGroup;
  cuentaDesc: FormControl;
  cuentaTipo: FormControl;
  cuentaFecha: FormControl;
  cuentaHora: FormControl;
  cuentaUsuario:FormControl;


  constructor(private cuentaService: CuentasService, private grupoCuentasService: GrupoCuentasService) { }

  ngOnInit() {
    this.formCuentas = new FormGroup({
      grupCuentas: new FormControl('--Seleccionar--'),
      cuentaDesc: new FormControl(),
      cuentaTipo: new FormControl(),
      cuentaFecha: new FormControl(),
      cuentaHora: new FormControl(),
      cuentaUsuario: new FormControl()
    });
    this.cuentaService.listAllCuentas().subscribe( data => {
      this.cuentas = data;
    });

    this.grupoCuentasService.listAllGrupoCuentas().subscribe(data => {
      this.grupoCuentas = data;
      console.log(JSON.stringify(this.grupoCuentas));
    });
  }

  ngOnChanges() {
    this.cuentaService.listAllCuentas().subscribe( data => {
      this.cuentas = data;
    });
  }

  public insertCuenta(cuenta: NgForm): void {

    // this.cambio = false;
    this.cuentaService.insertCuenta(cuenta).subscribe(result => {
    this.cuenta = result;
    // this.cambio = true;
    console.log('Save: ' + JSON.stringify(result));
    this.formCuentas.controls.tipoCuenta.setValue('--Seleccionar--');
    this.formCuentas.controls.grupoCuentaDesc.setValue(null);
    }, error => console.error('El error es: ' + error));
  }

}

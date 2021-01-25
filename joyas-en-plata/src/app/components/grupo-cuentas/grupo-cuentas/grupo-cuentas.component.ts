import { Component, OnInit, OnChanges} from '@angular/core';
import {GrupoCuentasService} from '../../../services/grupo-cuentas.service';
import {GrupoCuentas} from '../../../domains/GrupoCuentas';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { NgForm } from '@angular/forms';
import {TipoCuenta} from '../../../enums/TipoCuenta';
@Component({
  selector: 'app-grupo-cuentas',
  templateUrl: './grupo-cuentas.component.html',
  styleUrls: ['./grupo-cuentas.component.css']
})
export class GrupoCuentasComponent implements OnInit, OnChanges {

  optionsEnumTipoCuenta: string[];
  tipocuentas: TipoCuenta;
  TipoCuenta: typeof TipoCuenta = TipoCuenta;

  grupoCuentaId: FormControl;
  tipoCuenta: FormControl;
  grupoCuentaDesc: FormControl;


  tiposCuentas: TipoCuenta;
  valorTipoCuentas: TipoCuenta;

  grupCuenta: GrupoCuentas;
  grupoCuentas: GrupoCuentas[];

  cambio: boolean;
  formGroupGrupoCuentas: FormGroup;
  constructor(private grupoCuentasService: GrupoCuentasService) {
    this.formGroupGrupoCuentas = new FormGroup({
      grupoCuentaId:   new FormControl(),
      tipoCuenta:      new FormControl('--Seleccionar--'),
      grupoCuentaDesc: new FormControl()
    });
   }

  ngOnInit() {
    const options = Object.keys(TipoCuenta);
    this.optionsEnumTipoCuenta = options.slice(options.length / 2);
    this.grupoCuentasService.listAllGrupoCuentas().subscribe(data => {
      this.grupoCuentas = data;

    });

    /*this.formGroupGrupoCuentas = new FormGroup({
      grupoCuentaId:   new FormControl(),
      tipoCuenta:      new FormControl('--Seleccionar--'),
      grupoCuentaDesc: new FormControl()
    });*/
  }

  ngOnChanges() {

  }

  parseValue(value: string) {
    this.tipocuentas = TipoCuenta[value];
  }

  parseValueEnumTipoCuenta(value: string) {
    this.tipocuentas = TipoCuenta[value];
  }
  public insertGrupoCuentas(grupoCuentas: NgForm): void {
    this.cambio = false;
    console.log('entro aca ' + this.cambio);
    //console.log('ClientesForm: ' + JSON.stringify(this.formGroupGrupoCuentas.value));
    //console.log('Cliente: ' + JSON.stringify(grupoCuentas));
    this.grupoCuentasService.insertGrupoCuentas(grupoCuentas).subscribe(result => {
    this.grupCuenta = result;
    this.cambio = true;
    console.log('entro aca 2 ' + this.cambio);
    this.formGroupGrupoCuentas.controls.tipoCuenta.setValue('--Seleccionar--');
    this.formGroupGrupoCuentas.controls.grupoCuentaDesc.setValue(null);
    }, error => console.error('El error es: ' + error));

  }

}

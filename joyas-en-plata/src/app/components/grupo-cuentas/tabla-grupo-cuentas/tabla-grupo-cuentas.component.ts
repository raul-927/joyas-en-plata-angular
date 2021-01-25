import { JsonPipe } from '@angular/common';
import { Component, HostBinding, Input, OnInit, OnChanges } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { GrupoCuentas } from '../../../domains/GrupoCuentas';
import {GrupoCuentasService} from '../../../services/grupo-cuentas.service';
@Component({
  selector: 'app-tabla-grupo-cuentas',
  templateUrl: './tabla-grupo-cuentas.component.html',
  styleUrls: ['./tabla-grupo-cuentas.component.css']
})
export class TablaGrupoCuentasComponent implements OnInit, OnChanges {

  @HostBinding('attr.class')
  cssClass = 'row';

   grupoCuentas: GrupoCuentas[];
   grupoCuenta: GrupoCuentas;

   formTable: FormGroup;
   grupoCuentaDesc: FormControl;

   habilitoLapiz: boolean;

   @Input()
   cambio: boolean;

  constructor(private grupoCuentasService: GrupoCuentasService, fb:FormBuilder) {
    this.formTable = fb.group({
      grupoCuentaDesc: new FormControl()
    });
   }

  ngOnInit() {
    this.habilitoLapiz = true;
  }

  ngOnChanges() {
    console.log('cambio: '+this.cambio);
    this.grupoCuentas =[];
    this.grupoCuentasService.listAllGrupoCuentas().subscribe( data => {
      this.grupoCuentas = data;
    });
    this.grupoCuenta = null;
    this.formTable.controls['grupoCuentaDesc'].setValue("");

  }
  habilitoNombre(id: any) {
    const numero: number = this.grupoCuentas.length;
    console.log('numero: ' + numero);
    const aux = 'grupoCuentaDesc_' + id;
    this.grupoCuentas.forEach( data => {
      console.log('data id: ' + data.grupoCuentaId);
      console.log('id: ' + id);
      if (id === data.grupoCuentaId) {
        if (document.getElementById(aux).id === aux) {
          document.getElementById(aux).removeAttribute('disabled');
          document.getElementById(aux).setAttribute('enabled', 'enabled');
          this.habilitoBotonGrabar(id);
          this.habilitoLapiz = false;
        } else {
          document.getElementById(aux).removeAttribute('enabled');
          document.getElementById(aux).setAttribute('disabled', 'disabled');
          this.desHabilitoBotonGrabar(id);
          this.habilitoLapiz = true;
        }

      }
    });
  }

  habilitoBotonGrabar(id: any) {
    const aux = 'floppy_' + id;
    if (document.getElementById(aux).id === aux) {
      document.getElementById(aux).removeAttribute('disabled');
      document.getElementById(aux).setAttribute('enabled', 'enabled');
      this.habilitoLapiz = false;
    }

  }
  desHabilitoBotonGrabar(id: any) {
    const aux = 'floppy_' + id;
    if (document.getElementById(aux).id === aux) {
      document.getElementById(aux).removeAttribute('enabled');
      document.getElementById(aux).setAttribute('disabled', 'disabled');
      this.habilitoLapiz = true;
    }
  }
  actualizoNombre(id: any, tipo: any) {
    this.grupoCuenta = new GrupoCuentas();
    this.grupoCuenta.grupoCuentaId = id;
    this.grupoCuenta.tipoCuenta = tipo;
    this.grupoCuenta.grupoCuentaDesc = this.formTable.controls.grupoCuentaDesc.value;
    this.grupoCuentasService.updateGrupoCuentas(this.grupoCuenta).subscribe(result => {
      this.grupoCuenta = result;
      console.log('Update: ' + JSON.stringify(result));
      this.grupoCuenta.grupoCuentaId = 0;
      this.grupoCuenta.grupoCuentaDesc = null;
      this.grupoCuenta.tipoCuenta = null;
      id = 0;
      tipo = null;
      this.habilitoLapiz = true;
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

  eliminoRegistro(id: any) {
    this.grupoCuentasService.deleteGrupoCuentas(id).subscribe(result => {
      console.log('Delete: ' + JSON.stringify(result));
      if (!this.habilitoLapiz) {
        this.habilitoLapiz = true;
      }
      this.ngOnChanges();
    }, error => console.error('El error es: ' + error));
    console.log('eliminoRegistro cambio: ' + this.cambio);
  }

  public ingresoTexto(id:any, nombre:any):any{
    if(document.getElementById(id).id = id){
      this.grupoCuentaDesc.setValue(nombre);

    }
  }

}

import { Component, HostBinding, Input, OnInit, OnChanges } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
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

   formTable: FormGroup;

   @Input()
   cambio: boolean;

  constructor(private grupoCuentasService: GrupoCuentasService) {

   }

  ngOnInit() {
    this.formTable = new FormGroup({
      grupoCuentaDesc: new FormControl()
    });

  }

  ngOnChanges() {
    this.grupoCuentasService.listAllGrupoCuentas().subscribe( data => {
      this.grupoCuentas = data;
    });
  }
  prueba(id: any) {
    const aux = 'grupoCuentaDesc_' + id;
     console.log('aux: ' + aux);
    console.log('dom id: ' + document.getElementById(aux).id);

    if (document.getElementById(aux).id === aux) {
      document.getElementById(aux).removeAttribute('disabled');
      document.getElementById(aux).setAttribute('enabled', 'enabled');

    } else {
      document.getElementById(aux).removeAttribute('enabled');
      document.getElementById(aux).setAttribute('disabled', 'disabled');


    }
  }

}

import { ComponentFactory,
         ComponentRef,
         ViewContainerRef,
         Component,
         OnInit,
         AfterViewInit,
         ViewChild,
         ComponentFactoryResolver,
         Type } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FlashMessagesService } from 'angular2-flash-messages';
import { ComponentRegistry } from '../../../domains/ComponentRegistry';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit, AfterViewInit {

  constructor() { }

  ngOnInit() {
  }
  ngAfterViewInit() {

  }

}

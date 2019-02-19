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
import { ComponentRegistry } from '../../domains/ComponentRegistry';
@Component({
  selector: 'app-page-item',
  templateUrl: './page-item.component.html',
  styleUrls: ['./page-item.component.css']
})
export class PageItemComponent implements OnInit, AfterViewInit {

  constructor() { }

  ngOnInit() {
  }
  ngAfterViewInit() {

  }

}

import { ComponentFactory,
         ComponentRef,
         ViewContainerRef,
         Component,
         AfterViewInit,
         ViewChild,
         ComponentFactoryResolver,
         Type
} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {
  title = 'joyas-en-plata';
  ngAfterViewInit() {

  }
}

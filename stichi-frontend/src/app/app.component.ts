import { Component }    from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {DatePipe} from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls:   ['./app.component.css'],
  imports: [RouterOutlet, DatePipe]
})
export class AppComponent {
  today = new Date();
}

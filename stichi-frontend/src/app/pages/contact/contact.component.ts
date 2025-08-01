import { Component }                       from '@angular/core';
import { CommonModule }                    from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient }                      from '@angular/common/http';
import { RouterModule }                    from '@angular/router';
import { TranslateModule, TranslateService } from '@ngx-translate/core';

@Component({
  standalone: true,
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css'],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    TranslateModule
  ]
})
export class ContactComponent {
  form: FormGroup;
  success = false;
  error   = false;
  today   = new Date();

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private translate: TranslateService
  ) {
    this.form = this.fb.group({
      name:    ['', Validators.required],
      email:   ['', [Validators.required, Validators.email]],
      message: ['', Validators.required],
    });
    this.translate.setDefaultLang('en');
  }

  switchLang(): void {
    const next = this.translate.currentLang === 'ro' ? 'en' : 'ro';
    this.translate.use(next);
  }

  onSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.http.post('/api/contact', this.form.value).subscribe({
      next: () => {
        this.success = true;
        this.error   = false;
        this.form.reset();
      },
      error: () => {
        this.error   = true;
        this.success = false;
      }
    });
  }
}

import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient }    from '@angular/common/http';
import { provideRouter }        from '@angular/router';
import { importProvidersFrom }  from '@angular/core';
import { ReactiveFormsModule  }   from '@angular/forms';

import {
  TranslateModule,
  TranslateLoader
} from '@ngx-translate/core';
import {TRANSLATE_HTTP_LOADER_CONFIG, TranslateHttpLoader, TranslateHttpLoaderConfig} from '@ngx-translate/http-loader';

import { AppComponent }        from './app/app.component';
import { routes }              from './app/app.routes';

export function createTranslateLoader() {
  return new TranslateHttpLoader();
}

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    importProvidersFrom(ReactiveFormsModule),
    provideRouter(routes),
    {
      provide: TRANSLATE_HTTP_LOADER_CONFIG,
      useValue: {
        prefix: 'assets/i18n/',
        suffix: '.json'
      } as TranslateHttpLoaderConfig
    },
    importProvidersFrom(
      TranslateModule.forRoot({
        loader: {
          provide: TranslateLoader,
          useFactory: createTranslateLoader,
          deps: []
        },
        fallbackLang: 'en'
      })
    )
  ]
});

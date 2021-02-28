import {
  RouterModule,
  Routes
} from '@angular/router';

const routes: Routes = [
  { path: 'home' },
  { path: 'public/home' },
  { path: 'formation' },
  { path: 'form' },

  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

export const RouteRoutes = RouterModule.forChild(routes);

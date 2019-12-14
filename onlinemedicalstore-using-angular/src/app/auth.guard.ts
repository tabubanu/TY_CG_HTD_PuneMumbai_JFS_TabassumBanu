import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    user = JSON.parse(localStorage.getItem('user'));

    constructor(private auth: AuthService) { }

    canActivate(route: ActivatedRouteSnapshot): boolean {
        const expectedRoleArray = route.data.expectedRole;
        let expectedRole: string = null;
        for (const index in expectedRoleArray) {
            if (this.user && expectedRoleArray[index] === this.user.type) {
                expectedRole = expectedRoleArray[index];
            }
        }
        if (this.auth.isLoggedIn() && expectedRole === this.user.type) {
            console.log('user loggedIn');
            return true;
        } else {
            console.log('user not loggedin');
            return false;
        }
    }
}

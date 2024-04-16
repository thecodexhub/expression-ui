//
//  PixelPerfectVM.swift
//  example-swiftui
//
//  Created by Ifeanyi Onuoha on 16/04/2024.
//

import Foundation
import ExpressionUI


@Observable
class PixelPerfectVM {
    // Subscribe to Rive events and this delegate will be invoked
    func onStateEventReceived(onEvent event: StateEvent) {
        switch event.name {
        case "next_tapped":
            Router.shared.push(.composable)
        default:
            print("NOT IMPLEMENTED: \(event.name)")
        }
    }
}

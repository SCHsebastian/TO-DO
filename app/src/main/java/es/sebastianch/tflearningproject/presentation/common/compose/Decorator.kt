package es.sebastianch.tflearningproject.presentation.common.compose

interface Decorator<Element, Decorated>{
    fun applyStyle(element: Element): Decorated
}

FutureJS wall
=============

A small clojurescript canvas project for the workshop "diving into
clojurescript" of FutureJS

```
lein cljsbuild auto
```

Open lighttable and a browser tab, and connect to it to eval and play with the
code.

The different versions of the code are stored in `src-steps/`.


Steps
-----

### 1. Initial project

Look for project.clj. Compilation setup and dependencies.

**Web ouput is in `web/`**

`web/index.html` and a `web/style.css`

**Source is in src**
`src/futurejs_wall/core.cljs`

**For live development:**

* In a terminal: `lein cljsbuild auto`
* In Lighttable:
  * ctrl-space -> Add browser tab
  * Put the full url of your index.html as in Chrome
    `file:///Users/jkn/dev/projects/diving-into-clojurescript/code/exercises/futurejs-wall/web/index.html`
  * Go to `core.cljs`
  * cmd-enter on the `println`
  * When LT asks, choose the file url
  * Connected to a browser!!
  * Open the console (View -> Console) and see the println do its thing (shares browser tab console with LT console)


### 2. Namespace (module) and accessing JS stuff

Look at the top form on core.cljs

```
(ns futurejs-wall.core
  (:require [monet.canvas :as canvas]))
```

That means that we are in the module `core` of the module `futurejs-wall`, and the instruction below means we are importing the module `canvas` of the library `monet` aliased as `canvas`.

Using autocomplete and showing the docs we can explore the lib:

```
(canvas/init
;; init
;; monet.canvas
;; ([canvas & [context-type]])
```

We will use it later.

Lets mess around with the browser.

To access things from JS, we use the namespace/module `js/...`. Since in js there is only a global, from there we can get everything.

Try and eval this:

```
(js/alert "Hi!")
```

To call a method, we do `(.method object arg1 arg2)`:

```
(.write js/document "Hi!")
```

```
(def body (.querySelector js/document "body"))
```

To get properties `body.innerHTML` we use `.-innerHTML` instead:

```
(.-innerHTML body)
```

To set properties, we use the function `set!`:

```
(set! (.-innerHTML body) "Shut up.")
```

Cool, we know now.


### 3. Initialize our canvas.

We will use monet to manage the canvas. [Usage](https://github.com/rm-hull/monet) and [API](http://www.destructuring-bind.org/monet/)

* Get the dom element
* Initialize canvas/init and save the returning monet-canvas
* We can add entities to the canvas (auto drawed and auto updated).
* Add a background entity, as in the example usage

*Code is in `src-steps/1`*

### 4. Make the canvas fullscreen

* Get the window height and width.
* Set the dom canvas width and height.
* Change our background to be fullscreen.

*Code is in `src-steps/2`*

### 5. Organisation

* Move background related logic to its own namespace
* Define a create (for the value)
* Define a update (for the update fn)
* Define a render! (for the render fn)
* Move the color to the value instead of hardcoded in the render
* Change `core.cljs` to comply

*Code is in `src-steps/3`*

### 6. Add some text

We are going to add a big title.

* Create a new `text` namespace
* Follow the same as in background. Text will have `x` `y` and `text` values.
* Use the
* In `core.cljs` add at the end a section to add a new entity

*Code is in `src-steps/4`*

### 7. Animate background color randomly

We are going to make the background color animated randomly!

* Let's create a color ns for dealing with color logic
* We will agree that a color is a vector of its 3 components [r g b]
* Let's create a function that will generate a random color (hint: `rand-int`)
* Let's also create a function to convert a [r g b] to a "#rrggbb" str
  * Hint: (16).toString(16) === '10' & pad numbers to 2 digits
* Use our newly created random color fn in the background creation entity
  * Import
  * Change initial color to a random one
  * Change update to be a function that updates the color to a random one
    (hint: assoc)
    (hint: the return value of the update function will be the new value of the entity)
  * Change render! function to render the color as hex
* Don't forget to eval all the code
* Go to `core.cljs` and eval where we add the background entity

*Code is in `src-steps/5`*

*To stop the epileptic background, change the add-entity update function to nil and re-eval*

### 8. Soft background color animation

Let's make the background animate randomly but to closer softer variants.

* New fn in `color.cljs`. `randomize-color!`
  Takes a color and returns a new one that is slightly different than the one passed in.
* Use that in `background.cljs` to make the background updates smoother.

*Code is in `src-steps/6`*

### 9. Multiple tiles in the background!!

This is a bit boring, lets make the background be a collection of squares the of a random-size between 10 and 400 that ocupy all the
screen.

* Our background is now a map `{:x :y :width ...}`. We have to change it to be a collection of maps `[{} {} {}]` that fill up the whole screen.
* Lets mess with `background/create` to return that collection.




let gulp = require('gulp');
let del = require('del');

gulp.task('clean-dist', function () {
  return del([
    'dist/'
  ]);
});

gulp.task("copy", function() {
  return gulp.src(['index.html', 'images/**', 'scripts/**', 'config/**', 'styles/**'], {base: "."})
    .pipe(gulp.dest('dist/'));
});

gulp.task("dist", gulp.series(['clean-dist', 'copy']));

